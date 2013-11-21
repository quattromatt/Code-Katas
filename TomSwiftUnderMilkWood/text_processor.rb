class TextProcessor

	def process_text(text)

		hash = Hash.new
		last_word = nil
		two_words_ago = nil
		key = nil

		# Get an array of the words in the text
		words = text.split

		# Loop over each word
		words.each do |word|

			if !last_word.nil? && !two_words_ago.nil?
				key = two_words_ago + ' ' + last_word

				existing_value = hash[key]
				if existing_value.nil?
					value = [word]
					hash[key] = value
				else
					existing_value.push(word)
				end

				# puts key
			end

			two_words_ago = last_word
			last_word = word

		end


		hash.each do |key, value|

			foo = (key + ' => ')
			puts foo
			puts value
		end

	end

end