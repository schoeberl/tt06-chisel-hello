![](../../workflows/gds/badge.svg) ![](../../workflows/docs/badge.svg) ![](../../workflows/test/badge.svg)

# Tiny Tapeout Chisel Hello World

- Brief documentation of the project at: [Read the documentation for project](docs/info.md)

This hello world project is intended to show how projects are written in the Chisel hardware construction language.
To learn more about Chisel, visit the [Chisel website](https://www.chisel-lang.org/)
or read the free [Chisel book](http://www.imm.dtu.dk/~masca/chisel-book.html).

Note that this project includes a submodule. Therefore, you need to update with:

```
git submodule init
git submodule update
```

The project displays a counter on the 7-segment display.
It also writes out ``hello world`` in Morse on the DP of the 7-segment display.
Furthermore, it also playes the Morse with PWM on the BIDIR PMOD, connected to
a PmodAMP2.

## TODO

 * We should have tests that use ChiselTest

