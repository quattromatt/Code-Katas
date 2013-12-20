require_relative 'number_translator'

class RomanNumerals

	def execute()
		
		# Get a number translator
		translator = NumberTranslator.new

		# Define how high we want to count
		count_to = 1001
		number_to_count = 1

		# Count the numbers
		while number_to_count <= count_to do
			translator.translate(number_to_count)
			number_to_count = number_to_count + 1
		end

	end

end

kata = RomanNumerals.new
kata.execute