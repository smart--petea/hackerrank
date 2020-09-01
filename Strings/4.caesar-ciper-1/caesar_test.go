package caesar

import (
    "testing"
)

func TestCaesarCipherRune(t *testing.T) {
    var in rune = 'm'
    var expected rune = 'o'
    var out rune = CaesarCipherRune(in, 2) 
    if out != expected {
        t.Errorf("in:=%x out:=%x expected:=%x", in, out, expected)
    }

    in = 'z'
    out = CaesarCipherRune(in, 2) 
    expected = 'b'
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", string(in), string(out), string(expected))
    }

    in = '.'
    out = CaesarCipherRune(in, 2) 
    expected = '.'
    if out != expected {
        t.Errorf("in:=%x out:=%x expected:=%x", in, out, expected)
    }
}

func TestCaesarCipher(t *testing.T) {
    var in string = "middle-Outz"
    var k int32 = 2
    var expected string = "okffng-Qwvb"
    var out string = CaesarCipher(in, k)
    if out != expected {
        t.Errorf("in:=%s out:= %s, expected:=%s", in, out, expected)
    }
}
