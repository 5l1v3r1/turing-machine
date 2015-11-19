; Tell if a string of 0's and 1's is a palindrome.
; Output 1 to the current tape position if it is, 0 if not.
[
  () (1 1 0 1 0 1 0 0 0 1 0 1 0 1 1)
  [
    ; Surround the content with 2's
    {0 [0 0 :R] 1 [0 1 :R] nil [1 2 :L]}
    {0 [1 0 :L] 1 [1 1 :L] nil [2 2 :R]}
    
    ; State 2: while the current symbol is not 2, check if it equals the last symbol.
    {0 [3 2 :R] 1 [6 2 :R] 2 [8 1 :R]}
    
    ; State 3: while the current symbol is not 2, go to the right one. Then go to state 4.
    {0 [3 0 :R] 1 [3 1 :R] 2 [4 2 :L]}
    ; State 4: if we got a 0, then this one was a success; if it's a 1, we failed.
    {0 [5 2 :L] 1 [8 0 :R] 2 [8 1 :R]}
    ; State 5: go back to the first non-2 value
    {0 [5 0 :L] 1 [5 1 :L] 2 [2 2 :R]}
    
    ; State 6: while the current symbol is not 2, go to the right one. Then go to state 7.
    {0 [6 0 :R] 1 [6 1 :R] 2 [7 2 :L]}
    ; State 7: if we got a 1, then this one was a success; if it's a 0, we failed.
    {0 [8 0 :R] 1 [5 2 :L] 2 [8 1 :R]}
    
    ; State 8: finish.
    {0 [nil 0 :L] 1 [nil 1 :L] 2 [nil 2 :L]}
  ]
  0
]