package WikiSearch


import java.awt.Desktop
import java.net.URI
import java.net.URL
import java.net.URLEncoder


class SearchEngineMainClass(var inputQuery : String) {
    private val queryBase = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
    private val resultQuery = "https://ru.wikipedia.org/w/index.php?curid="

    var allQueryResults : List<WikiLinksList> = emptyList()
    var encodeQuery =
        URLEncoder.encode(inputQuery, "UTF-8") //Translates a string(inputQuery) into x-www-form-urlencoded format.
    val encodeQueryInJson =
        URL(queryBase + "\"$encodeQuery\"").readText()//Creates a URL object from the String representation.

    init {
        allQueryResults = getJson(encodeQueryInJson)
    }

    fun openLink(id : Int) {
        println(allQueryResults[id])
        Desktop.getDesktop().browse(URI(resultQuery + allQueryResults[id].queryLink))

    }
}




