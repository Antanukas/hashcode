import java.io.{BufferedOutputStream, File, FileOutputStream, FilenameFilter, PrintWriter}
import java.nio.file.{Files, StandardCopyOption}

import scala.collection.mutable
import scala.io.StdIn

object HashCode2018 extends App {

  @inline def tokenizeLine = new java.util.StringTokenizer(StdIn.readLine)
  def readInts(n: Int) = { val tl = tokenizeLine; Array.fill(n)(tl.nextToken.toInt) }

  def listInFiles: Array[File] = new File(".").listFiles(new FilenameFilter {
    override def accept(dir: File, name: String): Boolean = name.endsWith(".in")
  })

  def saveSolution(fileName: String, solution: Array[mutable.Set[Int]]): Unit = {
    val tmp = new File(s"tmp$fileName.txt")
    tmp.delete()
    tmp.createNewFile()
    val out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(tmp)))

    val nonEmptySols = solution.zipWithIndex.filter(_._1.nonEmpty)
    out.println(nonEmptySols.length)

    for {
      (sol, cacheId) <- nonEmptySols
    } out.println(s"$cacheId ${sol.mkString(" ")}")

    out.close()
    val tmpPath = tmp.toPath
    Files.move(tmpPath, tmpPath.resolveSibling(fileName + ".out"), StandardCopyOption.REPLACE_EXISTING)
  }

  def solve(fileOption: Option[File]) {

    val fileName = fileOption match {
      case Some(file) =>
        val name = file.getName
        println(name)
        Console.setIn(new java.io.BufferedInputStream(new java.io.FileInputStream(name)))
        name.take(name.lastIndexOf('.'))
      case None =>
        println("Input:")
        "console"
    }

    def score(sol: Array[mutable.Set[Int]]): Long = {
      2L //TODO
    }

    val solution = Array(mutable.Set(1, 2, 3))

    val Array(1) = readInts(1)
    saveSolution(fileName, solution)

    println("Score: " + score(solution))
  }

  println(args.mkString(","))
  if (args.length <= 1) solve(None) // console
  else if (args.tail sameElements Array("*")) listInFiles.foreach(f => solve(Some(f)))
  else args.tail.foreach(n => solve(Some(new File(n + ".in"))))
}
