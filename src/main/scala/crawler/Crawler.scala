package org.upenn.edu.medpie.crawler

import scala.actors._

sealed abstract class CrawlMsg

// Write entry to log file
case class WriteLog(time: java.util.Date, actor: Int, url: String, dst: String, msg: String) extends CrawlMsg

// Scheduler -> Logger, called after finished crawling
case class CloseLog extends CrawlMsg

// Logger -> Scheduler, finished logging
case class LogClosed extends CrawlMsg

// Scheduler -> Crawler, save this page if matching and feed back more links
case class CheckIt(url: String, waitMs: Int) extends CrawlMsg

// Crawler -> Scheduler, links for next iteration
case class Followed(links: List[String]) extends CrawlMsg

/*
 * Responsible for writing to the log file.
 */
class Logger(outPath: String) extends Actor {
  
  def act() {
    react {
      case WriteLog(time, actor, url, dst, msg) => 
      case PingLog() =>
    }
  }
  
  def exit() {
    reactWithin(0) {
      
    }
  }
  
}

/*
 * Responsible for setting the crawlers on their merry ways.
 */
class Scheduler extends Actor {
  
}

/*
 * Dumps content of web pages to the directory of choice, based on
 * the tasks given to it by the scheduler.
 */
class Crawler extends Actor {
  
}

object Crawler {
  def crawl {
    
  }
  
  
  
  
}
