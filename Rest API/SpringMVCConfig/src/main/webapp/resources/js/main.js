
function addToCart(productId){
    fetch(`/SpringMVCConfig/api/cart/${productId}`)
    .then(res => res.json())
    .then(data => {
        var d = document.getElementById("cart-counter")
        if(d){
            d.innerHTML = data
        }
    })
}

