import './sass/common.scss'

function component() {
    let element = document.createElement('div');
    
    element.classList.add('hello');

    var btn = document.createElement('button');
    btn.innerHTML = '点击这里，然后查看 console！';
    // btn.onclick = printMe;123123
    element.appendChild(btn);
    
    return element;
  }

  document.body.appendChild(component());