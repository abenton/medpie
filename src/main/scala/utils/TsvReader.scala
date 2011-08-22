package org.upenn.edu.medpie.utils

import scala.io.{Source, BufferedSource}

class TsvReader(val reader: BufferedSource, val header: List[String]) extends Iterable[List[String]] {
  
  class TsvIterator(val lineIter: Iterator[String]) extends Iterator[List[String]] {
    def hasNext: Boolean = lineIter hasNext
    
    def next(): List[String] = lineIter.next().split("\t").toList
  }
  
  def iterator(): Iterator[List[String]] = new TsvIterator(reader.getLines)
  
  /*
   * Get the value at a field by the column header.
   */
  def getField(val hField: String, val entry: List[String]): String = {
    def getFieldRec(val index: Int, val entry: List[String]): String = {
      if (index > 0) getFieldRec(index-1, entry tail)
      else entry head
    }
    
    fIndex = getFieldRec(entryheader.indexOf(hField), entry)
  }
}

object TsvReader {
  
  def apply(inPath: String, hasHeader: Boolean): TsvReader = {
    val source = Source.fromFile(inPath)
    hasHeader match {
      case true => {
	header = source.next split "\t"
	TsvReader(source, header toList)
      }
      case false => TsvReader(source, List())
    }
  }
  
}
