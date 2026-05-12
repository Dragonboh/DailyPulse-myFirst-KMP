//
//  AboutScreenView.swift
//  iosApp
//
//  Created by Bogdan Pankevych on 12.05.2026.
//

import SwiftUI
import Shared

struct AboutScreenView: View {
    let items = AboutScreenVM().getItems()
    
    var body: some View {
        NavigationStack {
            List {
                ForEach(items, id: \.self) { item in
                    VStack(alignment: .leading) {
                        Text("\(item.first ?? "UNDEFINED")")
                            .font(.headline)
                        Text("\(item.second ?? "UNDEFINED")")
                            .font(.subheadline)
                    }
                    .padding()
                }
            }
            .navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutScreenView()
}
