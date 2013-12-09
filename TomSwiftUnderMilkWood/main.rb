require_relative 'processors/ruby_string_processor'
require_relative 'processors/file_processor'
require_relative 'generators/text_generator'

class Trigrams

	def run()

		#processor = RubyStringProcessor.new
		processor = FileProcessor.new
		text_map = processor.process()

		# print our text map to see what it looks like
		# print_text_map(text_map)

		generator = TextGenerator.new
		start_words = pick_start_words(text_map)
		output = generator.generate_text(text_map, start_words, 200)

		formatted_output = ('Trigamerated output = "' + output + '"')
		puts formatted_output
	end

	def pick_start_words(text_map)

		random_index = rand(text_map.length)
		text_map.keys[random_index]

	end

	def print_text_map(text_map)
		text_map.each do |key, value|

			foo = (key + ' => ')
			puts foo
			puts value
		end
	end

end

trigrams = Trigrams.new
trigrams.run