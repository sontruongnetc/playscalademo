package models

case class Message() {
  var text: String = "ddd"
  private var _status: Int = 0
  
  // Getter
  def status = _status

  // Setter
  def status_(value: Int) = {
    _status = value
  }
}