package org.upenn.edu.medpie.utils
import java.io.{FileWriter, BufferedWriter}

/* 
 * Allows writing tab-delimited data to an output.
 */
class TsvWriter(val writer: BufferedWriter) extends Writer {
  
  def write(fields: Any*): Unit =
    writer.write(fields.map(_ toString).mkstring("\t") + '\n')
  
  def close(): Unit = writer.close()
}

object TsvWriter {
  
  /*
   * Supply the output file associated with this writer and its header.
   * Returns object that writes fields in TSV format.  Automatically toStrings
   * fields to be written.
   */
  def apply(val outPath: String, header: Any*): TsvWriter = {
    val fStream = new FileWriter(outPath)
    val writer = new BufferedWriter(fStream)
    header match {
      case h::t => writer.write(header.map(_ toString).mkString("\t") + '\n')
      case Nil => 
    }
    TsvWriter(writer)
  }
}
