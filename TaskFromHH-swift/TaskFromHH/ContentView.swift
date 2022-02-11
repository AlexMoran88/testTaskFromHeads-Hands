//
//  ContentView.swift
//  TaskFromHH
//
//  Created by john on 12.02.2022.
//

import SwiftUI

struct ContentView: View {
    @State var cost = ""

    var number: String {
        guard let cost = Int(cost) else {
            return "Use numbers only"
        }

        return String(getSortedArray(amountArrays: cost))
    }

    var body: some View {
        VStack {
            TextField("Please Enter N", text: $cost)
                .keyboardType(.decimalPad)
                .padding(10)
                .overlay(
                    RoundedRectangle(cornerRadius: 30)
                        .stroke(Color.blue, lineWidth: 1)
                )
                .padding()

            Text(number)
                .padding()
        }
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
