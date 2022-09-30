package WikiSearch

import com.google.gson.Gson
import com.google.gson.JsonObject

class WikiLinksList( var linkName : String, var queryLink : String) {

    fun checkResults() : String {
        return "$queryLink: \"$linkName\""
    }

}


 fun getJson(jsonQuery : String) : List<WikiLinksList> {
    var jsonList : MutableList<WikiLinksList> = mutableListOf()

    val jsonArray = Gson()
        .fromJson(jsonQuery, JsonObject::class.java)
        .getAsJsonObject("query")
        .getAsJsonArray("search")

    jsonArray.forEach {
        jsonList.add(WikiLinksList(it.asJsonObject.getAsJsonPrimitive("title").toString(),
            it.asJsonObject.getAsJsonPrimitive("pageid").toString()))
    }
    return jsonList
}
