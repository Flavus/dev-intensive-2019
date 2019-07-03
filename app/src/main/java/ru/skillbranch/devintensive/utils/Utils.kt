package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parts : List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        if (firstName == "") firstName = null
        if (lastName == "") lastName = null
//        return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val charMap = mapOf(
            "А" to "A", "Б" to "B", "В" to "V", "Г" to "G", "Д" to "D", "Е" to "E", "Ё" to "Yo", "Ж" to "Zh", "З" to "Z", "И" to "I", "Й" to "J",
            "К" to "K", "Л" to "L", "М" to "M", "Н" to "N", "О" to "O", "П" to "P", "Р" to "R", "С" to "S", "Т" to "T", "У" to "U", "Ф" to "F",
            "Х" to "H", "Ц" to "C", "Ч" to "Ch", "Ш" to "Sh", "Щ" to "Sh", "Ы" to "Y", "Ь" to "`", "Э" to "E`", "Ю" to "Yu", "Я" to "Ya",
            "а" to "a", "б" to "b", "в" to "v", "г" to "g", "д" to "d", "е" to "e", "ё" to "yo", "ж" to "zh", "з" to "z", "и" to "i", "й" to "j",
            "к" to "k", "л" to "l", "м" to "m", "н" to "n", "о" to "o", "п" to "p", "р" to "r", "с" to "s", "т" to "t", "у" to "u", "ф" to "f",
            "х" to "h", "ц" to "c", "ч" to "ch", "ш" to "sh", "щ" to "sh", "ъ" to "", "ы" to "y", "ь" to "`", "э" to "e`", "ю" to "yu", "я" to "ya")
        var res = ""
        var char: String
        for (i in 0 until payload.length) {
            char = payload[i].toString()
            if (charMap.contains(char)) res += charMap.getValue(char)
            else when (char) {
                " " -> res += divider
                else -> res += char
            }
        }
        return res
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return firstName?.get(0).toString().plus((lastName?.get(0) ?: "" ).toString())
    }
}