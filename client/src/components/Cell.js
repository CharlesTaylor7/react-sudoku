import React, {useState, useRef} from "react"
import "./Cell.css"

export const Cell = () => {
  const [value, setValue] = useState();
  const inputElement = useRef(null);

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
    <div
      className="cell"
      onClick={() => inputElement.current.focus() }>
      <input
        className="input"
        type="text"
        ref={inputElement}
        onChange={e => changeValue(e.target.value)} />
    </div>
  )
}
