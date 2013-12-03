class TextGenerator

	def generate_text(text_map, word_pair, num_words_to_generate)

		sentence = word_pair
		value = nil
		next_word = ''

		counter = 0
		while counter < num_words_to_generate && !next_word.nil? do
			counter = counter + 1

			value = text_map[word_pair.downcase]

			if value.nil?
				next_word = nil
			else
				next_word = pick_the_next_word(value)
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

	def pick_the_next_word(words)
		random_index = rand(words.length)
		words[random_index]
	end
end