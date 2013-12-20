class NumberTranslator

	def translate(number)
		puts 'the number is: '
		puts number

		translated = ''

		str_number = number.to_s()
		len = str_number.length
		index = len - 1
		factor = 1

		while index >= 0 do
			number_part = str_number[index].to_i() * factor

			translated = translate_part(number_part) + translated

			factor = factor * 10
			index = index - 1
		end

		puts translated
	end

	def translate_part(number)
		'TODO'
	end

end