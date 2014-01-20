class NumberPlaceTranslator

	def initialize(ones, fives, tens)
		@ones = ones
		@fives = fives
		@tens = tens
	end

	def translate(number)
		roman_numerals = '';

		if number <= 3
			while number > 0 do
				roman_numerals << @ones
				number = number - 1
			end
		elsif number == 4
			roman_numerals = @ones + @fives
		elsif number == 5
			roman_numerals = @fives
		elsif number < 9
			roman_numerals = @fives

			number = number - 5
			while number > 0 do
				roman_numerals = roman_numerals + @ones
				number = number - 1
			end
		elsif number == 9
			roman_numerals = @ones + @tens
		else
			roman_numerals = @tens
		end

		roman_numerals
	end

end