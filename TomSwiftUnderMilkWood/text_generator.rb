class TextGenerator

	def generate_text(text_map, word_pair, num_words_to_generate)

		sentence = word_pair
		value = nil
		next_word = ''

		counter = 0
		while counter < num_words_to_generate do
			counter = counter + 1

			value = text_map[word_pair]

			if value.nil?
				next_word = nil
			else
				next_word = value[0]
				sentence = sentence + ' ' + next_word
				word_pair = get_next_word_pair(word_pair, next_word)
			end

		end

		sentence
	end

	def get_next_word_pair(word_pair, word)
		
		words = word_pair.split
		next_word_pair = words[1] + ' ' + word

		puts next_word_pair

		return next_word_pair
	end
end