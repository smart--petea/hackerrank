package m

import (
    "testing"
)

func TestHackerrankInString(t *testing.T) {
    var in, out, expected string

    in = "hereiamstackerrank"
    expected = "YES"
    out = HackerrankInString(in)
    if out != expected {
        t.Errorf("in:=%s, out:=%s, expected:=%s", in, out, expected)
    }

    in = "hackerworld"
    expected = "NO"
    out = HackerrankInString(in)
    if out != expected {
        t.Errorf("in:=%s, out:=%s, expected:=%s", in, out, expected)
    }

    in = "hhaacckkekraraannk"
    expected = "YES"
    out = HackerrankInString(in)
    if out != expected {
        t.Errorf("in:=%s, out:=%s, expected:=%s", in, out, expected)
    }

    in = "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytkt"
    expected = "NO"
    out = HackerrankInString(in)
    if out != expected {
        t.Errorf("in:=%s, out:=%s, expected:=%s", in, out, expected)
    }
}
