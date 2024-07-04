import React, { Component } from 'react';
import { Box, Button } from '@material-ui/core';

class Counter extends Component {

    constructor(){
        super(); // react 는 상속받는 상위 생성자를 반드시 작성해 주어야 함
        this.state = {
            count : 5,
        }
    }

    increment(){
        this.setState({
            count : this.state.count + 1,
        })
    }

    decrement(){
        this.setState({
            count : this.state.count - 1,
        })
    }

    render(){
        return(
            <div>
                <Button variant = 'contained' color = 'primary' size = 'large' onClick={ this.increment.bind(this) }> + </Button>
                <Box component = 'span' m = '5' > { this.state.count } </Box>
                <Button variant = 'contained' color = 'primary' size = 'large' onClick={ this.decrement.bind(this) }> - </Button>
            </div>
        )
    }
}

export default Counter;