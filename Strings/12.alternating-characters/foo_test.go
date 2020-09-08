package q

import (
    "testing"
)

func TestAlternatingCharacters(t *testing.T) {
    var in string
    var out, expected int32

    in = "AAAA"
    expected = 3
    out = AlternatingCharacters(in)
    if expected != out {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }

    in = "BBBBB"
    expected = 4
    out = AlternatingCharacters(in)
    if expected != out {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }

    in = "ABABABAB"
    expected = 0
    out = AlternatingCharacters(in)
    if expected != out {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }

    in = "AAABBB"
    expected = 4
    out = AlternatingCharacters(in)
    if expected != out {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }
}
