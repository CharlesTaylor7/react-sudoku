import React from "react"
import "./NumberInput.css"
export class NumberInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = { isEditing: false };
  }

  onChange(event) {
    this.props.onChange(event.target.value);
  }

  toggleEditing() {
    this.setState({ isEditing: !this.state.isEditing });
  }

  render() {
    return (
      <input
          className="number static"
          type="text"
          name={this.props.name}
          value={this.props.value}
          onBlur={this.toggleEditing.bind(this)}
          onFocus={this.toggleEditing.bind(this)}
          onChange={this.onChange.bind(this)}
          readOnly={this.props.isEditing}
      />
    );
  }
}
