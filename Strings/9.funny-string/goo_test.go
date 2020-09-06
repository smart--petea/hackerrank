package n

import (
    "testing"
)

func TestIsFunny(t *testing.T) {
    var in string
    var out, expected bool

    in = "acxz"
    expected = true
    out = IsFunny(in)
    if out != expected {
        t.Errorf("in:=%s out:=%t expected:=%t", in, out, expected)
    }

    in = "bcxz"
    expected = false
    out = IsFunny(in)
    if out != expected {
        t.Errorf("in:=%s out:=%t expected:=%t", in, out, expected)
    }

    in = "ab"
    expected = true
    out = IsFunny(in)
    if out != expected {
        t.Errorf("in:=%s out:=%t expected:=%t", in, out, expected)
    }

    in = "abc"
    expected = true
    out = IsFunny(in)
    if out != expected {
        t.Errorf("in:=%s out:=%t expected:=%t", in, out, expected)
    }
}
