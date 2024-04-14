import chisel3._
import chisel3.util._

/*
      -- 1 --
     |       |
     6       2
     |       |
      -- 7 --
     |       |
     5       3
     |       |
      -- 4 --
*/
class Decoder extends Module {

  val counter = IO(Input(UInt(4.W)))
  val segments = IO(Output(UInt(7.W)))

  segments := 0.U
  switch (counter) {
    is(0.U) {
      segments := "b0111111".U
    }
    is(1.U) {
      segments := "b0000110".U
    }
    is(2.U) {
      segments := "b1011011".U
    }
    is(3.U) {
      segments := "b1001111".U
    }
    is(4.U) {
      segments := "b1100110".U
    }
    is(5.U) {
      segments := "b1101101".U
    }
    is(6.U) {
      segments := "b1111100".U
    }
    is(7.U) {
      segments := "b0000111".U
    }
    is(8.U) {
      segments := "b1111111".U
    }
    is(9.U) {
      segments := "b1100111".U
    }
  }
}
