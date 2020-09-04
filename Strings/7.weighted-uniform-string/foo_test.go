package m

import (
    "testing"
)

func TestWeightedUniformStrings(t *testing.T) {
    var in string 
    var queries []int32
    var expected []string

    in = "abccddde"
    queries = []int32{6, 1, 3, 12, 5, 9, 10}
    out := WeightedUniformStrings(in, queries)
    expected = []string{"Yes", "Yes", "Yes", "Yes", "No", "No"}

    for i, outVal := range out {
        if outVal != expected[i] {
            t.Errorf("outVal:=%s, expectedVal=%s", outVal, expected[i])
        }
    }
}
