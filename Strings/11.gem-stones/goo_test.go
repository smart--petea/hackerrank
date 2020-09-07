package g

import (
    "testing"
)

func TestGemstones(t *testing.T) {
    var in []string  
    var out, expected int32

    in = []string {
        "abcdde",
        "baccd",
        "eeabg",
    }
    expected = 2
    out = Gemstones(in)
    if out != expected {
        t.Errorf("in=%v, out=%d, expected=%d\n", in, out, expected)
    }
}
