package it.iquii.test.reddit.library.android.entity

fun String.isValidUrl(): Boolean{
   val regex =  "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|png)".toRegex()
   return regex.matches(this)
}