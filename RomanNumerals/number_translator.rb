class NumberTranslator

	def translate(number)
		puts 'the number is: '
		puts number

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
		'H'
	end

	def translate_tens(number)
		'Te'
	end

	def translate_ones(number)
		'O'
	end

end