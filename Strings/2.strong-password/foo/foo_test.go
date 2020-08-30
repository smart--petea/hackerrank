package foo

import (
    "testing"
)

func TestMinimumNumber(t *testing.T) {
    number := MinimumNumberStr("")
    if number != 6 {
        t.Errorf("Got number %d, exptected 6\n", number)
    }

    number = MinimumNumberStr("a")
    if number != 5 {
        t.Errorf("Got number %d, exptected 5\n", number)
    }

    number = MinimumNumberStr("ab")
    if number != 4 {
        t.Errorf("Got number %d, exptected 4\n", number)
    }

    number = MinimumNumberStr("ab1")
    if number != 3 {
        t.Errorf("Got number %d, exptected 3\n", number)
    }

    number = MinimumNumberStr("#HackerRank")
    if number != 1 {
        t.Errorf("Got number %d, exptected 1\n", number)
    }
}
