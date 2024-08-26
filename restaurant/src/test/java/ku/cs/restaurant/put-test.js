// 6510451000 Sittipat Tepsutar

const id = "67533f27-61ea-428d-b0dd-86b6d90f14c0"


async function main() {
    let res
    res = await putRestaurantTest(id, "A", 5, "A");
    console.log(await res.json());
}



/**
 * @param {String} id
 * @param {String} name 
 * @param {Number} rating 
 * @param {String} location 
 * @returns {Promise<Response>}
 */
async function putRestaurantTest(id, name, rating, location) {
    return await fetch("http://localhost:8090/restaurant", {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id,
            name: name,
            rating: rating,
            location: location
        }
        )
    })
}

main();