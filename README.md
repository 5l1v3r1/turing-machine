# turing

A Turing Machine implementation in Clojure.

## Usage

Simply do `lein run <myfile.clj>` to run the Turing machine stored in a file. Machines are represented in the following format:

    [
      (LEFT TAPE) (CURRENT SYMBOL, RIGHT TAPE)
      [
        {SYMBOL [NEWSTATE NEWSYMBOL :R/:L] ... nil [SYMBOL NEWSYMBOL :R/:L]}
        ...
      ]
      0
    ]

The tapes are represented as two lists, one for the left tape, and one for the right tape. Each state transition is a vector with three elements: a new state index, a new symbol, and a direction (`:R` or `:L`). The symbol `nil` represents a blank, so a `nil` rule can be used to handle blank symbols.

For an example, see [examples/set-1.clj](examples/set-1.clj) which replaces all of its input symbols with 1's and adds a 0 on either end of the input.

## License

I am too busy to pursue anybody legally for any reason. Go ahead and steal this code. And then steal my watch, my laptop, and my phone. I won't stop you.
