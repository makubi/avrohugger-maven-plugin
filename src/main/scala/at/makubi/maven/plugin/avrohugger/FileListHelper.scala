package at.makubi.maven.plugin.avrohugger

import java.io.File

trait FileListHelper {
  def listFiles(directory: File, recursive: Boolean): Seq[File]
}

class DefaultFileListHelper extends FileListHelper {

  override def listFiles(directory: File, recursive: Boolean): Seq[File] = {
    listFiles(Seq(directory), recursive, Seq.empty)
  }

  def listFiles(inputFiles: Seq[File], recursive: Boolean, accFiles: Seq[File]): Seq[File] = {
    val files = inputFiles.filter(_.isFile) ++: accFiles
    val subFiles = inputFiles.filter(_.isDirectory).flatMap(_.listFiles())
    if (recursive && subFiles.nonEmpty) listFiles(subFiles, recursive, files)
    else files ++: subFiles.filter(_.isFile)
  }
}
