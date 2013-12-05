require_relative 'processors/ruby_string_processor'
require_relative 'processors/file_processor'
require_relative 'generators/text_generator'

class Trigrams

	def run()

		processor = RubyStringProcessor.new
		#processor = FileProcessor.new
		text_map = processor.process()

		# print our text map to see what it looks like
		# print_text_map(text_map)
		puts(text_map['Old King'])

		generator = TextGenerator.new
		output = generator.generate_text(text_map, 'Old King', 200)

		formatted_output = ('Trigamerated output = "' + output + '"')
		puts formatted_output
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