package p

import (
    "testing"
)


func TestIsPangram(t *testing.T) {
    var in string
    var out, expected bool


    in = "we promptly judged antique ivory buckles for the next prize"
    out = IsPanagram(in)
    expected = true
    if out != expected {
        t.Errorf("in:=%s out:=%t expected:=%t", in, out, expected)
    }

    in = "We promptly judged antique ivory buckles for the prize"
    out = IsPanagram(in)
    expected = false
    if out != expected {
        t.Errorf("in:=%s out:=%t expected:=%t", in, out, expected)
    }
}
