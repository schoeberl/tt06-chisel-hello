import chisel3._
import chisel3.util._

/**
 * Example design in Chisel.
 * A redesign of the Tiny Tapeout example.
 */
class ChiselTop() extends Module {
  val io = IO(new Bundle {
    val ui_in = Input(UInt(8.W))      // Dedicated inputs
    val uo_out = Output(UInt(8.W))    // Dedicated outputs
    val uio_in = Input(UInt(8.W))     // IOs: Input path
    val uio_out = Output(UInt(8.W))   // IOs: Output path
    val uio_oe = Output(UInt(8.W))    // IOs: Enable path (active high: 0=input, 1=output)
    val ena = Input(Bool())           // will go high when the design is enabled
  })

  io.uio_out := 0.U
  // use bi-directionals as input
  io.uio_oe := 0.U

  val ledReg = RegInit(0.U(1.W))
  val digitReg = RegInit(0.U(4.W))

  // Blink with 1 Hz
  val (cnt, tick) = Counter(true.B, 25000000)
  when (tick) {
    ledReg := ~ledReg
    digitReg := digitReg + 1.U
    when (digitReg === 9.U) {
      digitReg := 0.U
    }
  }
  val dec = Module(new Decoder)
  dec.counter := digitReg
  io.uo_out := ledReg ## dec.segments
}

object ChiselTop extends App {
  emitVerilog(new ChiselTop(), Array("--target-dir", "src"))
}