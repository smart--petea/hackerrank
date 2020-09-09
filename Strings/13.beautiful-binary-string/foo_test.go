package a

func TestBeautifulBinaryString(t *testing.T) {
    var in string
    var out, expected int32

    in = "0101010"
    expected = 2
    out = BeautifulBinaryString(in)
    if out != expected {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }

    in = "01100"
    expected = 0
    out = BeautifulBinaryString(in)
    if out != expected {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }

    in = "0100101010"
    expected = 3
    out = BeautifulBinaryString(in)
    if out != expected {
        t.Errorf("in=%s out=%d expected=%d", in, out, expected)
    }
}
