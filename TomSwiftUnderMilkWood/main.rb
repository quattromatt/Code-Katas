require_relative 'text_processor'
require_relative 'text_generator'

class Trigrams

	def run()
		puts 'Trigrams:'

		processor = TextProcessor.new
		text_map = processor.process_text('This is some random junk that is going to be trigramerated!')

		generator = TextGenerator.new
		output = generator.generate_text(text_map)

		# puts output
	end

end

trigrams = Trigrams.new
trigrams.run