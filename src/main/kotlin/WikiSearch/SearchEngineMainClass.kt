package WikiSearch

import java.net.URL
import java.net.URLEncoder

class WikiLinksList(private var linkName:String, private var queryLink:String){

     fun checkResults(): String {
        return "$queryLink: \"$linkName\""
    }

}

class SearchEngineMainClass(var inputQuery : String) {

    val encodeQuery = URLEncoder.encode(inputQuery, "UTF-8") //Translates a string(inputQuery) into x-www-form-urlencoded format.
    val encodeQueryInJson= URL(encodeQuery).readText()//Creates a URL object from the String representation.
    var allQueryResults: List<WikiLinksList> = emptyList()


}