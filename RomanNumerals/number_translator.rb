require_relative 'number_slicer'

class NumberTranslator

	def translate(number)

		number_slicer = NumberSlicer.new
		number_slices = number_slicer.slice_number(number)

		puts number_slices

		# TODO - Create a common class that can translate thousands, hundreds, tens, and ones

	end

	def translate_old(number)
		#puts 'the number is: '
		#puts number

		translated = ''

		str_number = number.to_s()
		len = str_number.length

		index = 0
		factor = 10 ** (len - 1)

		while index < len do
			number_part = str_number[index].to_i() * factor

			translated = translated + translate_part(number_part, factor)

			factor = factor / 10
			index = index + 1
		end

		puts translated
	end

	def translate_part(number, factor)

		if number == 0
			return '' 
		end

		case factor
		when 1000
			translate_thousands(number)
		when 100
			translate_hundreds(number)
		when 10
			translate_tens(number)
		when 1
			translate_ones(number)
		else
			'ERROR'
		end

	end

	def translate_thousands(number)
		translated = ''
		while number > 0
			translated = translated + 'M'
			number = number - 1000
		end
		translated
	end

	def translate_hundreds(number)
		translate_with_roman_numerals(number / 100, 'C', 'D', 'M')
	end

	def translate_tens(number)
		translate_with_roman_numerals(number / 10, 'X', 'L', 'C')
	end

	def translate_ones(number)
		translate_with_roman_numerals(number, 'I', 'V', 'X')
	end

	def translate_with_roman_numerals(number, ones, fives, tens)
		roman_numerals = '';

		if number <= 3
			while number > 0 do
				roman_numerals << ones
				number = number - 1
			end
		elsif number == 4
			roman_numerals = ones + fives
		elsif number == 5
			roman_numerals = fives
		elsif number < 9
			roman_numerals = fives

			number = number - 5
			while number > 0 do
				roman_numerals = roman_numerals + ones
				number = number - 1
			end
		elsif number == 9
			roman_numerals = ones + tens
		else
			roman_numerals = tens
		end


		roman_numerals
	end
end