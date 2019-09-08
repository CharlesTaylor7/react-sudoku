import React, {useState, useRef} from "react"
import "./Cell.css"
// import NumericInput from "react-numeric-input"
import NumberInput from "react-number-input"

export const Cell = () => {
  const [value, setValue] = useState();

  const changeValue = (val) => {
    if (val) {
      const num = Number(val[0]);
      setValue(num);
    }
    else {
      setValue("");
    }
  };

  return (
    <div className="cell">
      <NumberInput
        className="number-input"
        min={1}
        max={9}
        value={value}
        placeholder="_"
        onChange={e => console.log(e)}
      />
    </div>
  )
}
