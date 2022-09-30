package WikiSearch

fun main() {
   println ("Hello, what up? Enter your query, please!")
   val query=readln()
   println (query)

      val searchResult = SearchEngineMainClass(query)

      searchResult.allQueryResults.forEach {
         println(it)
      }

      println("Write the number of the page you want to open")
      val number = readln().toInt()

      searchResult.openLink(number)

}