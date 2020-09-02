package mars

import "testing"

func TestMarsExploration(t *testing.T) {
    var in string
    var expected, out int32

    in = "SOSSPSSQSSOR"
    expected = 3
    out = MarsExploration(in)
    if expected != out {
        t.Errorf("in:=%s, out:=%d, expected:=%d", in, out, expected)
    }

    in = "SOSSOT"
    expected = 1
    out = MarsExploration(in)
    if expected != out {
        t.Errorf("in:=%s, out:=%d, expected:=%d", in, out, expected)
    }

    in = "SOSSOSSOS"
    expected = 0
    out = MarsExploration(in)
    if expected != out {
        t.Errorf("in:=%s, out:=%d, expected:=%d", in, out, expected)
    }
}
