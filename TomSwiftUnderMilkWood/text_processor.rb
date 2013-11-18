class TextProcessor

	def process_text(text)

		last_word = nil
		key = nil

		# Get an array of the words in the text
		words = text.split

		# Loop over each word
		words.each do |word|

			if !last_word.nil?
				key = last_word + ' ' + word
				puts key
			end

			last_word = word

		end

	end

end