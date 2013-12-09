require_relative 'line_processor'

class FileProcessor

	def process()

		# Instantiate a text map
		text_map = Hash.new

		# Loop through the file and process each line
		File.open(@@file, "r").each_line do |line|
			process_line(line, text_map)
		end

		# Return the text map
		text_map
	end

	def process_line(line, text_map)

		@@line_processor.process(line, text_map)

	end

	@@file = 'files/TwoChristmasCelebrations-TheodoreParker.txt'
	@@line_processor = LineProcessor.new
end