package com.black.kaunbanegacrorepati

object Constants {

    const val USERNAME: String = "username"
    const val CORRECT: String = "correctAnswer"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,
                        "Who was the first Indian woman in Space?",
                        "Kalpana Chawla",
                        "Sunita Williams",
                        "Koneru Humpy",
                        "None of the above",
                            1)

        questionList.add(que1)

        val que2 = Question(2,
            "Who was the first Indian in Space?",
            "Vikram Ambalal",
            "Ravish Malhotra",
            "Rakesh Sharma",
            "Nagapathi Bhat",
            3)

        questionList.add(que2)

        val que3 = Question(3,
            "Who was the first Man to Climb Mount Everest Without Oxygen?",
            "Junko Tabei",
            "Reinhold Messner",
            "Peter Habeler",
            "Phu Dorji",
            4)

        questionList.add(que3)

        val que4 = Question(4,
            "Who built the Jama Masjid?",
            "Jahangir",
            "Akbar",
            "Imam Bukhari",
            "Shah Jahan",
            4)

        questionList.add(que4)

        val que5 = Question(5,
            "Who wrote the Indian National Anthem?",
            "Bakim Chandra Chatterji",
            " Rabindranath Tagore",
            "Swami Vivekanand",
            "None of the above",
            2)

        questionList.add(que5)

        val que6 = Question(6,
            "Who was the first Indian Scientist to win a Nobel Prize?",
            "CV Raman",
            "Amartya Sen",
            "Hargobind Khorana",
            "Subramanian Chrandrashekar",
            1)

        questionList.add(que6)

        val que7 = Question(7,
            "Who was the first Indian to win the Booker Prize?",
            "Dhan Gopal Mukerji",
            "Nirad C. Chaudhuri",
            "Arundhati Roy",
            "Aravind Adiga",
            3)

        questionList.add(que7)

        val que8 = Question(8,
            "Who was the first President of India?",
            "Abdul Kalam",
            "Lal Bahadur Shastri",
            "Dr. Rajendra Prasad",
            "Zakir Hussain",
            3)

        questionList.add(que8)

        val que9 = Question(9,
            "Who was the first Indian woman to win the Miss World Title?",
            "Aishwarya Rai",
            "Sushmita Sen",
            "Reita Faria",
            "Diya Mirza",
            3)

        questionList.add(que9)

        val que10 = Question(10,
            "Who is the first Indian to win a Nobel Prize?",
            "Rabidranath Tagore",
            "CV Raman",
            "Mother Theresa",
            "Hargobind Khorana",
            1)

        questionList.add(que10)

        return questionList
    }
}