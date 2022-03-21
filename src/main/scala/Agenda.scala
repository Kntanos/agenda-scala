class Agenda (val meetings: List[Meeting]) {

  def printDaySchedule(day: String): Unit = {
    val meetingsForTheDay = meetings.filter(_.day == day)
    if (meetingsForTheDay.nonEmpty) {
      for (meeting <- meetingsForTheDay) {
        if (meeting.time.endsWith("am")) {
          println(s"$day morning:")
          println(s"  ${meeting.time}: ${meeting.name}")
        } else {
          println(s"$day afternoon:")
          println(s"  ${meeting.time}: ${meeting.name}")
        }
      }
    } else {
      println(s"$day:")
      println(s"  There are no meetings on $day")
    }
  }

}

class Meeting (val name: String, val day: String, val time: String)

object Main extends App {
  val m1 = new Meeting("Retro", "Friday", "5pm")
  val m2 = new Meeting("Yoga", "Tuesday", "10am")
  val m3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val m4 = new Meeting("Other Meeting", "Tuesday", "2pm")
  val agenda = new Agenda(List(m1, m2, m3, m4))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
}