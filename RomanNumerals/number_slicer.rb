class NumberSlicer

	def slice_number(number)

		number_parts = Array.new

		number_str = pad_number(number)

		for index in [0..3]
			number_parts.push(number_str[index])
		end

		number_parts

	end

	def pad_number(number)

		number_str = number.to_s()
		len = number_str.length

		while len < 4 do
			number_str = '0' + number_str
			len = len + 1
		end

		number_str
	end
end