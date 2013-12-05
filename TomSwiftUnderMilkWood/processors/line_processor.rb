class LineProcessor

	def process(line, text_map)

		last_word = nil
		two_words_ago = nil
		key = nil

		# Get an array of the words in the text
		words = line.split

		# Loop over each word
		words.each do |word|

			word = word.match('[^.,;"]+')[0].strip

			if !last_word.nil? && !two_words_ago.nil?
				key = two_words_ago + ' ' + last_word

				existing_value = text_map[key]
				if existing_value.nil?
					value = [word]
					text_map[key.downcase] = value
				else
					existing_value.push(word)
				end
			end

			two_words_ago = last_word
			last_word = word

		end

		text_map

	end
end