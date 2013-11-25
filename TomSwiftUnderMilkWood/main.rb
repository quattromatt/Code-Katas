require_relative 'text_processor'
require_relative 'text_generator'

class Trigrams

	def run()
		puts 'Trigrams:'

		processor = TextProcessor.new
		text_map = processor.process_text('I hope that this will come out to something kinda cool.  I need some more words in this sentence so that the output will be interesting.  This is some random junk that is going to be trigramerated! This is another sentence.')

		# print our text map to see what it looks like
		# print_text_map(text_map)

		generator = TextGenerator.new
		output = generator.generate_text(text_map, 'I hope', 200)

		formatted_output = ('OUTPUT = "' + output + '"')
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