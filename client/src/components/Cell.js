import React, {useState} from "react"
import "./Cell.css"

export const Cell = () => {

  const [value, setValue] = useState();
  const changeValue = (val) => {
    if (!Number.isInteger(val) || val < 1 || val > 9) {
      throw new Error("Cell value must be an integer between 1 & 9.")
    }
    setValue(val)
  };

  return (
    <div className="cell">
      <span
        className="cell-content underline">
        {value ? value : ""}
      </span>
    </div>
  )
}
